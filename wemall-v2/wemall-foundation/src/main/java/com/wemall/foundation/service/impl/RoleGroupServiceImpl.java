package com.wemall.foundation.service.impl;

import com.wemall.core.dao.IGenericDAO;
import com.wemall.core.query.GenericPageList;
import com.wemall.core.query.PageObject;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.RoleGroup;
import com.wemall.foundation.service.IRoleGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RoleGroupServiceImpl
    implements IRoleGroupService {
    @Resource(name = "roleGroupDAO")
    private IGenericDAO<RoleGroup> roleGroupDao;

    public boolean save(RoleGroup roleGroup){
        try {
            this.roleGroupDao.save(roleGroup);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public RoleGroup getObjById(Long id){
        RoleGroup roleGroup = (RoleGroup)this.roleGroupDao.get(id);
        if (roleGroup != null){
            return roleGroup;
        }

        return null;
    }

    public boolean delete(Long id){
        try {
            this.roleGroupDao.remove(id);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean batchDelete(List<Serializable> roleGroupIds){
        for (Serializable id : roleGroupIds){
            delete((Long)id);
        }

        return true;
    }

    public IPageList list(IQueryObject properties){
        if (properties == null){
            return null;
        }
        String query = properties.getQuery();
        Map params = properties.getParameters();
        GenericPageList pList = new GenericPageList(RoleGroup.class, query,
                params, this.roleGroupDao);
        if (properties != null){
            PageObject pageObj = properties.getPageObj();
            if (pageObj != null)
                pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
                             .getCurrentPage().intValue(), pageObj.getPageSize() == null ? 0 :
                             pageObj.getPageSize().intValue());
        }else{
            pList.doList(0, -1);
        }

        return pList;
    }

    public boolean update(RoleGroup roleGroup){
        try {
            this.roleGroupDao.update(roleGroup);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public List<RoleGroup> query(String query, Map params, int begin, int max){
        return this.roleGroupDao.query(query, params, begin, max);
    }

    public RoleGroup getObjByProperty(String propertyName, Object value){
        return (RoleGroup)this.roleGroupDao.getBy(propertyName, value);
    }
}




