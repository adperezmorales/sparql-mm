package com.github.tkurz.sparqlmm.temporal.relation;

import com.github.tkurz.media.fragments.base.MediaFragmentURI;
import com.github.tkurz.media.fragments.exceptions.MediaFragmentURISyntaxException;
import com.github.tkurz.sparqlmm.utils.FunctionDoc;
import com.google.common.base.Preconditions;
import com.github.tkurz.sparqlmm.Constants;
import com.github.tkurz.sparqlmm.temporal.TemporalFunctionHelper;
import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.query.algebra.evaluation.ValueExprEvaluationException;
import org.openrdf.query.algebra.evaluation.function.Function;

/**
 * ...
 * <p/>
 * Author: Thomas Kurz (tkurz@apache.org)
 */
@FunctionDoc(title = "temporalEqual", reference = FunctionDoc.Reference.temporal, description = "returns true if resource1.start == resource2.start and resource1.end == resource2.end, else false.")
public class EqualFunction implements Function {

    /**
     * return the URI
     */
    public String getURI() {
        return Constants.NAMESPACE + "temporalEqual";
    }

    @Override
    public Value evaluate(ValueFactory valueFactory, Value... values) throws ValueExprEvaluationException {
        try {
            Preconditions.checkArgument(values.length == 2, "Number of Arguments is not correct");

            //check if values are correct
            MediaFragmentURI[] uris = TemporalFunctionHelper.parseURIs(values);

            return valueFactory.createLiteral(uris[0].getMediaFragment().getTemporalFragment().equal(uris[1].getMediaFragment().getTemporalFragment()));

        } catch (MediaFragmentURISyntaxException e) {
            return valueFactory.createLiteral(false);
        }

    }
}
