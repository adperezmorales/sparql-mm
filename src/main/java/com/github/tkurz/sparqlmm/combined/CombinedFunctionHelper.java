package com.github.tkurz.sparqlmm.combined;

import com.github.tkurz.media.fragments.base.MediaFragmentURI;
import com.github.tkurz.media.fragments.exceptions.MediaFragmentURISyntaxException;
import com.github.tkurz.media.fragments.utils.MediaFragments;
import com.google.common.base.Preconditions;
import org.openrdf.model.URI;
import org.openrdf.model.Value;

/**
 * ...
 * <p/>
 * Author: Thomas Kurz (tkurz@apache.org)
 */
public class CombinedFunctionHelper {

    public static MediaFragmentURI[] parseURIs(Value... values) throws MediaFragmentURISyntaxException {

        try {
            MediaFragmentURI[] uris = new MediaFragmentURI[values.length];

            for(int i = 0; i < values.length; i++) {
                Preconditions.checkArgument(values[i] instanceof URI, "Argument %s must be a URI", i);
                uris[i] = new MediaFragmentURI(values[i].toString());
            }

            return uris;
        } catch (IllegalArgumentException e) {
            throw new MediaFragmentURISyntaxException(e);
        }
    }

}
