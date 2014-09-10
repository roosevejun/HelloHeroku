package com.tongtu.repository;

import com.tongtu.bean.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * 系统登录日志
 *
 * @author tt01
 */
@RepositoryRestResource(collectionResourceRel = "app", path = "app")
public interface AppRepository extends JpaRepository<App, String>,JpaSpecificationExecutor<App> {

}
