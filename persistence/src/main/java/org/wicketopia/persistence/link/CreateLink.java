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

package org.wicketopia.persistence.link;

import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.IModel;
import org.wicketopia.persistence.PersistenceProvider;


public abstract class CreateLink<T> extends SubmitLink
{
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    private final PersistenceProvider persistenceProvider;

//----------------------------------------------------------------------------------------------------------------------
// Constructors
//----------------------------------------------------------------------------------------------------------------------

    public CreateLink(String id, IModel<T> model, PersistenceProvider persistenceProvider)
    {
        super(id, model);
        this.persistenceProvider = persistenceProvider;
    }

//----------------------------------------------------------------------------------------------------------------------
// Abstract Methods
//----------------------------------------------------------------------------------------------------------------------

    protected abstract void afterCreate(T object);

//----------------------------------------------------------------------------------------------------------------------
// IFormSubmittingComponent Implementation
//----------------------------------------------------------------------------------------------------------------------

    @Override
    @SuppressWarnings("unchecked")
    public final void onSubmit()
    {
        T object = (T) getDefaultModelObject();
        object = persistenceProvider.create(object);
        afterCreate(object);
    }
}