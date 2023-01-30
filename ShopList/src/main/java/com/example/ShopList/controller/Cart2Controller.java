package com.example.ShopList.controller;

import com.example.ShopList.service.Cart2Service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class Cart2Controller
    {
        @Autowired
        private Cart2Service cart2Service;

        /*@DeleteMapping(path = "/carts/{name}")
        public ResponseEntity<Void> deleteByName(@RequestParam String name)
        {
            cart2Service.deleteByName(name);

        }*/
    }
