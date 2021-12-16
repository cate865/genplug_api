package com.genplug.genplug.services;

import com.genplug.genplug.classes.Blog;
import com.genplug.genplug.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    // add a blog
    public Blog addBlog(Blog blog){
        blogRepository.save(blog);
        return blog;
    }

    // view a blog
    public Blog viewBlog(Long id){
        return blogRepository.findById(id).get();
    }

    // view all blogs
    public List<Blog> viewAllBlogs(){
        return (List<Blog>) blogRepository.findAll();
    }
}
