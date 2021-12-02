package com.example.webapp.repository;

import com.example.webapp.api.model.MatchSearchParameter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomMatchRepositoryImpl implements CustomMatchRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MatchEntity> searchByParams(MatchSearchParameter searchParameter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MatchEntity> query = cb.createQuery(MatchEntity.class);
        Root<MatchEntity> root = query.from(MatchEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (searchParameter.getStartTimeFrom() != null) {
            predicates.add(cb.greaterThan(root.get("startTime"), searchParameter.getStartTimeFrom()));
        }
        if (searchParameter.getStartTimeTo() != null) {
            predicates.add(cb.lessThan(root.get("startTime"), searchParameter.getStartTimeTo()));
        }
        if (searchParameter.getFirstTeam() != null && !searchParameter.getFirstTeam().isEmpty()) {
            if (searchParameter.isSearchAnyCombination()) {
                predicates.add(cb.or(
                        cb.equal(root.get("firstTeam"), searchParameter.getFirstTeam()),
                        cb.equal(root.get("secondTeam"), searchParameter.getFirstTeam()
                        )));
            } else {
                predicates.add(cb.equal(root.get("firstTeam"), searchParameter.getFirstTeam()));
            }
        }
        if (searchParameter.getSecondTeam() != null && !searchParameter.getSecondTeam().isEmpty()) {
            if (searchParameter.isSearchAnyCombination()) {
                predicates.add(cb.or(
                        cb.equal(root.get("firstTeam"), searchParameter.getSecondTeam()),
                        cb.equal(root.get("secondTeam"), searchParameter.getSecondTeam()
                        )));
            } else {
                predicates.add(cb.equal(root.get("secondTeam"), searchParameter.getSecondTeam()));
            }
        }

            query.where(predicates.toArray(new Predicate[predicates.size()]));
            return entityManager.createQuery(query).getResultList();
        }
    }

