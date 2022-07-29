package com.cts.dailynav.dailynav.service;

import com.cts.dailynav.dailynav.exception.MutualFundNameNotFoundException;
import com.cts.dailynav.dailynav.model.MutualFundDetails;
import com.cts.dailynav.dailynav.repository.MutualFundDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutualFundDetailsService {
    private MutualFundDao mutualFundDao;
    @Autowired
    public void setMutualFundDao(MutualFundDao mutualFundDao) {
        this.mutualFundDao = mutualFundDao;
    }
    public MutualFundDetails getMutualFundDetails(String mutualFundName) throws MutualFundNameNotFoundException {
        MutualFundDetails mutualFundDetails = mutualFundDao.findByMutualFundName(mutualFundName);
        if(mutualFundDetails == null) {
            throw new MutualFundNameNotFoundException("MutualFund Not Found");
        }
        return mutualFundDetails;
    }
}
