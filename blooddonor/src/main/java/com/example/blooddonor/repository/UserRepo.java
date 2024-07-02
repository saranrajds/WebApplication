package com.example.blooddonor.repository;

import com.example.blooddonor.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.blooddonor.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findById(Integer id);

    @Query("SELECT u FROM User u WHERE " +
            "(:bloodGroupId IS NULL OR :bloodGroupId = -1 OR u.bloodGroupId = :bloodGroupId) AND " +
            "(:countryId IS NULL OR :countryId = -1 OR u.countryId = :countryId) AND " +
            "(:stateId IS NULL OR :stateId = -1 OR u.stateId = :stateId) AND " +
            "(:districtId IS NULL OR :districtId = -1 OR u.districtId = :districtId) AND " +
            "(:cityId IS NULL OR :cityId = -1 OR u.cityId = :cityId)")
    List<User> findUsersByCriteria(
            @Param("bloodGroupId") Integer bloodGroupId,
            @Param("countryId") Integer countryId,
            @Param("stateId") Integer stateId,
            @Param("districtId") Integer districtId,
            @Param("cityId") Integer cityId
    );

}