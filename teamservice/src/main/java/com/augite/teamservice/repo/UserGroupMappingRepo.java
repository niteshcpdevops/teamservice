package com.augite.teamservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.augite.teamservice.model.UserGroupMapping;

public interface UserGroupMappingRepo extends JpaRepository<UserGroupMapping,Integer>{

	
	//@Query(value="SELECT a.ID, a.USER_UID, b.USERNAME, a.GROUP_NAME, a.DATE_TIME_CREATED, a.DATE_TIME_MODIFIED FROM AUGITE.USER_GROUP_MAPPING a, AUGITE.USERS b WHERE a.GROUP_NAME='CENTRAL_TRADE' AND a.USER_UID=b.USER_UID",nativeQuery = true)
	@Query(value="SELECT a.ID, a.USER_UID, b.USERNAME, a.GROUP_NAME FROM AUGITE.USER_GROUP_MAPPING a, AUGITE.USERS b WHERE a.GROUP_NAME=:groupname AND a.USER_UID=b.USER_UID",nativeQuery = true)
    List<UserGroupMapping> findUsersByGroupName(@Param("groupname")String groupName);
    
}
