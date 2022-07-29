package com.cts.dailynav.dailynav.controller;

import com.cts.dailynav.dailynav.exception.AuthorizationException;
import com.cts.dailynav.dailynav.exception.MutualFundNameNotFoundException;
import com.cts.dailynav.dailynav.feign.AuthorisingClient;
import com.cts.dailynav.dailynav.model.MutualFundDetails;
import com.cts.dailynav.dailynav.service.MutualFundDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MutualFundNavController {
    private MutualFundDetailsService service;
    private AuthorisingClient authorisingClient;
    @Autowired
    public void setService(MutualFundDetailsService service) {
        this.service = service;
    }
    @Autowired
    public void setAuthorisingClient(AuthorisingClient authorisingClient) {
        this.authorisingClient = authorisingClient;
    }

    @GetMapping("/mutualFundNav/{mutualFundName}")
    public MutualFundDetails getDailyNavValue(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader
            , @PathVariable String mutualFundName) throws AuthorizationException, MutualFundNameNotFoundException {
        System.out.println("Getting Current Nav Value............");
        if(authorisingClient.authorizeTheRequest(requestTokenHeader)) {
            return service.getMutualFundDetails(mutualFundName);
        }
        else {
            throw new AuthorizationException("Not allowed");
        }
    }
}
