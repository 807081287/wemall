package com.wemall.foundation.service;

import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.Consult;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IConsultService {
    public abstract boolean save(Consult paramConsult);

    public abstract Consult getObjById(Long paramLong);

    public abstract boolean delete(Long paramLong);

    public abstract boolean batchDelete(List<Serializable> paramList);

    public abstract IPageList list(IQueryObject paramIQueryObject);

    public abstract boolean update(Consult paramConsult);

    public abstract List<Consult> query(String paramString, Map paramMap, int paramInt1, int paramInt2);
}




