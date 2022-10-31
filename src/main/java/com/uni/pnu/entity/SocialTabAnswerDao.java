package com.uni.pnu.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialTabAnswerDao extends CrudRepository<SocialTabAnswer, Integer> {
}
