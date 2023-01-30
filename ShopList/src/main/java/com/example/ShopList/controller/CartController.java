package com.example.ShopList.controller;

import com.example.ShopList.model.Cart;
import com.example.ShopList.model.CartResponse;
import com.example.ShopList.model.Item;
import com.example.ShopList.service.CartItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class CartController
    {
        @Autowired
        private CartItemService cartService;

        @PostMapping(path = "/items",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<CartResponse> createCart(@RequestBody Cart cart)
        {
            CartResponse cartResponse=cartService.createCart(cart);
            log.info("created successfully with id " + cartResponse);
            return new ResponseEntity<>(cartResponse, HttpStatus.OK);
        }

        @GetMapping(path = "/items/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Cart> getById(@PathVariable Long id){
            Cart cart= cartService.getById(id);
            log.info("Get Done With Id"+id);
            return new ResponseEntity<>(cart,HttpStatus.OK);
        }

        @DeleteMapping (path = "/items/{id}")
        public ResponseEntity<Void> deleteById(@PathVariable Long id)
        {
            cartService.deleteById(id);
            log.info("Delete Successful");
            return ResponseEntity.ok().build();
        }

        @PutMapping(path ="/items/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Cart> updateById(@PathVariable Long id , @RequestBody Cart cart)
        {
            cart=cartService.updateById(id, cart);
            return new ResponseEntity<>(cart,HttpStatus.OK);
        }

        @GetMapping(value = "/carts", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Cart>> getAllCart() {
            List<Cart> cartRequest = cartService.getCartAll();
            return new ResponseEntity<>(cartRequest, HttpStatus.OK);
        }
        @PutMapping(path = "/carts/{itemName}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Void> updateCart(@RequestBody Item item, @PathVariable String itemName)  {
            cartService.updateCart(item,itemName);
            return ResponseEntity.ok().build();
        }

        /*@DeleteMapping(path = "/cart-Items/{itemName}")
        public ResponseEntity<Void> deleteItem(@PathVariable String itemName){
            cartService.deleteItem(itemName);
            return ResponseEntity.ok().build();
        }*/

    }
