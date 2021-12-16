package com.genplug.genplug.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.genplug.genplug.classes.Blog;
import com.genplug.genplug.classes.Profession;
import com.genplug.genplug.classes.Professional;
import com.genplug.genplug.repositories.ProfessionRepository;
import com.genplug.genplug.repositories.ProfessionalRepository;
import com.genplug.genplug.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    ProfessionRepository professionRepository;

    @Autowired
    ProfessionalRepository professionalRepository;

    //add a blog
    @PostMapping(path="/blog/add", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Blog addBlog(@RequestBody ObjectNode objectNode) throws MalformedURLException, URISyntaxException {
        String title = objectNode.get("title").asText();
        String professionName = objectNode.get("profession").asText();
        String owner = objectNode.get("owner").asText();
        String url = objectNode.get("url").asText();

        Blog newBlog = new Blog();

        List<Profession> professionsList = (List<Profession>) professionRepository.findAll();
        for (Profession profession : professionsList
        ) {
            if (profession.getName().equals(professionName)) {
                newBlog.setProfession(profession);
            }
        }

        List<Professional> professionalList = (List<Professional>) professionalRepository.findAll();
        for (Professional professional : professionalList
        ) {
            if (professional.getName().equals(owner)) {
                newBlog.setOwner(professional);
            }
        }

        newBlog.setTitle(title);

        URI uri = new URI(url);
        URL newUrl = uri.toURL();

        newBlog.setUrl(newUrl);


        return blogService.addBlog(newBlog);


    }

    // View all blogs
    @GetMapping(path = "/blog/all", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Blog> viewAllBlogs(){
        return blogService.viewAllBlogs();
    }




    }
