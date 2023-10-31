package com.weather.forecast.api.controller;


import com.weather.forecast.api.model.Store;
import com.weather.forecast.api.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

    private StoreService storeService;

    @Autowired
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    @Operation(summary = "Create a new store record")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "201", description = "store created", content = { @Content(mediaType = "application/json")} ),
            @ApiResponse(responseCode = "404", description = "Bad request") })
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Store store) {
        Store response = storeService.saveStoreWithProducts(store);
        return new ResponseEntity<Store>( response, HttpStatus.OK );
    }

    @Operation(summary = "View a list of stores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/list", produces = "application/json")
    public Iterable<Store> list(){
        Iterable<Store> stores = storeService.findAll();
        return stores;
    }
}
