package com.example.ShopList.service;

import com.example.ShopList.entity.CartEntity;
import com.example.ShopList.entity.ItemEntity;
import com.example.ShopList.mapper.CartMapper;
import com.example.ShopList.mapper.ItemMapper;
import com.example.ShopList.model.Cart;
import com.example.ShopList.model.CartResponse;
import com.example.ShopList.model.Item;
import com.example.ShopList.repository.CartRepository;
import com.example.ShopList.repository.ItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CartItemService
    {
        @Autowired
        private CartRepository cartRepository;

        @Autowired
        private ItemRepository itemRepository;

        @Autowired
        private CartMapper cartMapper;

        @Autowired
        private ItemMapper itemMapper;


        public CartResponse createCart(Cart cart)
        {
            CartEntity cartEntity = null;
            cartEntity = cartMapper.cartToEntity(cart);
            cartRepository.save(cartEntity);
            CartResponse cartResponse = new CartResponse();
            cartResponse.setId(cartEntity.getId());
            log.info("Posting.......");
            return cartResponse;
        }

        public Cart getById(Long id)
        {
            Optional<CartEntity>cartEntityOptional=cartRepository.findById(id);
            Cart cart=new Cart();
            if(cartEntityOptional.isPresent())
            {
              cart=cartMapper.entityToCart(cartEntityOptional.get());
                log.info("Fetching......");
            }
            else
            {
                log.info("Id not Found");
            }

            return cart;
        }

        public List<Cart> getCartAll() {

            List<CartEntity> cartEntityList = cartRepository.findAll();
            List<Cart> cartRequest=cartMapper.entityToCarts(cartEntityList);

            return cartRequest;
        }

        public void deleteById(Long id)
        {

            Optional<CartEntity> cartEntityOptional= cartRepository.findById(id);

            if(cartEntityOptional.isPresent())
            {
                log.info("Deleting......");
                cartRepository.deleteById(id);
            }

            else
            {
                log.info("cart Id {} not Found ",id);
            }
        }

        public Cart updateById (Long id, Cart cart  )
        {
            CartEntity cartEntity =cartRepository.getOne(id);
            cartEntity=cartMapper.cartToEntity(cart);


          //  cartEntity.setId(id);
         //   cartEntity.setItems();
            for (ItemEntity item: cartEntity.getItems())
            {
             item.setCart(cartEntity);
             item.setId(id);
            }
            cartRepository.save(cartEntity);

            cart=cartMapper.entityToCart(cartEntity);
            return cart;
        }

       /* public Cart updateById(Long id, Cart cart)
        {
            Optional<CartEntity>cartEntityOptional=cartRepository.findById(id);
            if (cartEntityOptional.isPresent())
            {
                CartEntity cartEntity=cartEntityOptional.get();
                cartEntity.setFirstName(cart.getFirstName());
                cartEntity.setLastName(cart.getLastName());

                List<ItemEntity>entities=new ArrayList<>();
                entities.add(cartEntity.getItems().get(0).getItemName());
                for (ItemEntity item: cartEntity.getItems())
                {

                }

            }
            else
            {
                log.info("{} Id Not Found",id);
            }

            return cart;
        }*/

      /*  public void deleteItem(String itemName)
        {
            Optional<ItemEntity> itemEntity= itemRepository.findBy(itemName);

            if(itemEntity.isPresent())
            {
                log.info("Deleting......");
                itemRepository.d();
            }



        }*/

        public void updateCart(Item item, String itemName) {
            ItemEntity itemEntity = itemRepository.findByItemName(itemName);
            if (itemEntity.getItemName().equalsIgnoreCase(itemName)){
                itemEntity.setQuantity(item.getQuantity());
                itemEntity.setPrice(item.getPrice());
                itemRepository.save(itemEntity);
            }
        }
    }
