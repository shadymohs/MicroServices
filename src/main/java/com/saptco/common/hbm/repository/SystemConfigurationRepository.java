package com.saptco.common.hbm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saptco.common.hbm.SystemConfiguration;

@Repository
public interface SystemConfigurationRepository extends CrudRepository<SystemConfiguration, Long> {

}