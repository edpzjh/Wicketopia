package org.wicketopia.persistence.component.link;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.wicketopia.persistence.PersistenceProvider;

public class DeleteLink<T> extends Link<T>
{
//**********************************************************************************************************************
// Fields
//**********************************************************************************************************************

    private PersistenceProvider persistenceProvider;

//**********************************************************************************************************************
// Constructors
//**********************************************************************************************************************

    public DeleteLink(String id, IModel<T> model, PersistenceProvider persistenceProvider)
    {
        super(id, model);
        this.persistenceProvider = persistenceProvider;
    }

//**********************************************************************************************************************
// Other Methods
//**********************************************************************************************************************

    @Override
    public final void onClick()
    {
        final T object = getModelObject();
        persistenceProvider.delete(object);
        afterDelete(object);
    }

    protected void afterDelete(T object)
    {

    }
}