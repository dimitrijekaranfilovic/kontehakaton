package org.konteh.kontehakatonbackend.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.konteh.kontehakatonbackend.model.BaseEntity;

import java.io.Serializable;
import java.util.UUID;

public class IdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        var entity = (BaseEntity)o;
        if (entity.getId() == null)
            return UUID.randomUUID().toString();
        else {
            return entity.getId();
        }
    }
}
