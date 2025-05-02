package org.fh.waiterApp.adapter.out.persistence;

import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import com.mongodb.client.model.changestream.FullDocument;
import io.quarkus.mongodb.ChangeStreamOptions;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.mongodb.client.model.Filters.in;

@ApplicationScoped
public class AccountReactiveRepository implements ReactivePanacheMongoRepositoryBase<AccountEntity, String> {

    public Multi<AccountEntity> subscribeById(String id) {
        List<Bson> pipeline = Arrays.asList(
                Aggregates.match(in("operationType", Arrays.asList("insert", "update", "replace")))
        );

        return Multi.createFrom().publisher(
                        mongoCollection().watch(pipeline, AccountEntity.class, new ChangeStreamOptions().fullDocument(FullDocument.UPDATE_LOOKUP))
                ).onItem().transform(ChangeStreamDocument::getFullDocument)
                .select().where(Objects::nonNull);
    }

}