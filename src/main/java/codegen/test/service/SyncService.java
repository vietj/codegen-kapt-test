package codegen.test.service;





import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.time.ZonedDateTime;
@VertxGen
@ProxyGen
public interface SyncService{


    void handle0(ZonedDateTime request , Handler<AsyncResult<Boolean>> handler);

    void handle1(String request , Handler<AsyncResult<Boolean>> handler);

}
