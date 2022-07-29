package com.cts.dailynav.dailynav.repository;

import com.cts.dailynav.dailynav.model.MutualFundDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MutualFundDao extends JpaRepository<MutualFundDetails, Integer> {
    public MutualFundDetails findByMutualFundName(String mutualFundName);
}
