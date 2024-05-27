// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */

// package com.example.demo.service;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.Tutorial;
// import com.example.demo.repository.TutorialRepository;

// /**
//  *
//  * @author moladin
//  */
// @Service
// public class TutorialService {

//   @Autowired
//   TutorialRepository tutorialRepository;

//   static List<Tutorial> tutorials = new ArrayList<>();
//   static long id = 0;

//   public List<Tutorial> findAll() {
//     try {
//       List<Tutorial> tutorials = new ArrayList<>();
      
//       tutorialRepository.findAll().forEach(tutorials::add);

//       return tutorials.isEmpty() ? Collections.emptyList() : tutorials;

//     } catch (Exception e) {
//       return null;
//     }
//   }

//   public List<Tutorial> findByTitleContaining(String title) {
//     return tutorials.stream().filter(tutorial -> tutorial.getTitle().contains(title)).toList();
//   }

//   public Tutorial findById(long id) {
//     return tutorials.stream().filter(tutorial -> id == tutorial.getId()).findAny().orElse(null);
//   }

//   public Tutorial save(Tutorial tutorial) {
//     // update Tutorial
//     if (tutorial.getId() != 0) {
//       long _id = tutorial.getId();

//       for (int idx = 0; idx < tutorials.size(); idx++)
//         if (_id == tutorials.get(idx).getId()) {
//           tutorials.set(idx, tutorial);
//           break;
//         }

//       return tutorial;
//     }

//     // create new Tutorial
//     tutorial.setId(++id);
//     tutorials.add(tutorial);
//     return tutorial;
//   }

//   public void deleteById(long id) {
//     tutorials.removeIf(tutorial -> id == tutorial.getId());
//   }

//   public void deleteAll() {
//     tutorials.removeAll(tutorials);
//   }

//   public List<Tutorial> findByPublished(boolean isPublished) {
//     return tutorials.stream().filter(tutorial -> isPublished == tutorial.isPublished()).toList();
//   }
// }
