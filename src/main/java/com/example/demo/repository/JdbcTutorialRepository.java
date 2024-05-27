/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tutorial;

@Repository
class JdbcTutorialRepository implements TutorialRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public int save(Tutorial tutorial) {
    return jdbcTemplate.update("INSERT INTO posts (title, description, ispublished) VALUES(?,?,?)",
        new Object[] { tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished() });
  }

  @Override
  public int update(Tutorial tutorial) {
    return jdbcTemplate.update("UPDATE posts SET title=?, description=?, ispublished=? WHERE id=?",
        new Object[] { tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished(), tutorial.getId() });
  }

  @Override
  public Tutorial findById(Long id) {
    try {
      Tutorial tutorial = jdbcTemplate.queryForObject("SELECT * FROM posts WHERE id=?",
          BeanPropertyRowMapper.newInstance(Tutorial.class), id);

      return tutorial;
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  @Override
  public int deleteById(Long id) {
    return jdbcTemplate.update("DELETE FROM posts WHERE id=?", id);
  }

  @Override
  public List<Tutorial> findAll() {
    return jdbcTemplate.query("SELECT * from posts", BeanPropertyRowMapper.newInstance(Tutorial.class));
  }

  @Override
  public List<Tutorial> findByPublished(boolean published) {
    return jdbcTemplate.query("SELECT * from posts WHERE ispublished=?",
        BeanPropertyRowMapper.newInstance(Tutorial.class), published);
  }

  @Override
  public List<Tutorial> findByTitleContaining(String title) {
    String q = "SELECT * from posts WHERE title ILIKE '%" + title + "%'";

    return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Tutorial.class));
  }

  @Override
  public int deleteAll() {
    return jdbcTemplate.update("DELETE from posts");
  }
}