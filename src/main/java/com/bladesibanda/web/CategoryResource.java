package com.bladesibanda.web;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.bladesibanda.service.CategoryService;
import com.bladesibanda.web.dto.CategoryDto;
import com.bladesibanda.web.dto.ProductDto;

@Path("/categories")
public class CategoryResource {
  @Inject
  CategoryService categoryService;

  @GET
  public List<CategoryDto> findAll() {
    return this.categoryService.findAll();
  }

  @GET
  @Path("/{id}")
  public CategoryDto findById(@PathParam("id") Long id) {
    return this.categoryService.findById(id);
  }

  @GET
  @Path("/{id}/products")
  public List<ProductDto> findProductsByCategory(@PathParam("id") Long id) {
    return this.categoryService.findProductsByCategoryId(id);
  }

  @POST
  public CategoryDto create(@Valid CategoryDto categoryDto) {
    return this.categoryService.create(categoryDto);
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam("id") Long id) {
    this.categoryService.delete(id);
  }
}
