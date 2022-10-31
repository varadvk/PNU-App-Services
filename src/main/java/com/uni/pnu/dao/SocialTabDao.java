package com.uni.pnu.dao;

import com.uni.pnu.entity.SocialTab;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SocialTabDao extends CrudRepository<SocialTab, Integer> {

//    @Query("SELECT * FROM Social_tab st WHERE st.question like %:key%")
    public List<SocialTab> findByQuestionContainingIgnoreCase(String key);
}
