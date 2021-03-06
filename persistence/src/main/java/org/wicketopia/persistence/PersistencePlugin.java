/*
 * Copyright (c) 2011 Carman Consulting, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wicketopia.persistence;

import org.wicketopia.Wicketopia;
import org.wicketopia.WicketopiaPlugin;
import org.wicketopia.persistence.editor.provider.EntityDropDownChoicePropertyEditorProvider;

public class PersistencePlugin implements WicketopiaPlugin
{
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    public static final String ENTITY_DDC = "entity-ddc";

    private final PersistenceProvider persistenceProvider;

//----------------------------------------------------------------------------------------------------------------------
// Static Methods
//----------------------------------------------------------------------------------------------------------------------

    public static PersistencePlugin get()
    {
        return Wicketopia.get().getPlugin(PersistencePlugin.class);
    }

//----------------------------------------------------------------------------------------------------------------------
// Constructors
//----------------------------------------------------------------------------------------------------------------------

    public PersistencePlugin(PersistenceProvider persistenceProvider)
    {
        this.persistenceProvider = persistenceProvider;
    }

//----------------------------------------------------------------------------------------------------------------------
// WicketopiaPlugin Implementation
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public void initialize(Wicketopia wicketopia)
    {
        wicketopia.addPropertyEditorProvider(ENTITY_DDC, new EntityDropDownChoicePropertyEditorProvider());
    }

//----------------------------------------------------------------------------------------------------------------------
// Getter/Setter Methods
//----------------------------------------------------------------------------------------------------------------------

    public PersistenceProvider getPersistenceProvider()
    {
        return persistenceProvider;
    }
}
