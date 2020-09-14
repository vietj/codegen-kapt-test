package codegen.test.service;





import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.time.ZonedDateTime;
@VertxGen
@ProxyGen
public interface SyncService{


    void handle(String request , Handler<AsyncResult<Boolean>> handler);

}
