/*
 * Copyright (c) 2011 Carman Consulting, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wicketopia.persistence.jpa;

import org.wicketopia.persistence.PersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author James Carman
 */
public class JpaPersistenceProvider implements PersistenceProvider
{
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    @PersistenceContext
    private EntityManager entityManager;

//----------------------------------------------------------------------------------------------------------------------
// PersistenceProvider Implementation
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public <T> T create(T object)
    {
        entityManager.persist(object);
        return object;
    }

    @Override
    public <T> void delete(T object)
    {
        entityManager.remove(object);
    }

    @Override
    public <T> T update(T object)
    {
        return entityManager.merge(object);
    }
}
