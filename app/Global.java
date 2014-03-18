import controllers.Keys;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        // TODO use DI
        Keys.PUBLIC_KEY = app.configuration().getString("marvel.public.key");
        Keys.PRIVATE_KEY = app.configuration().getString("marvel.private.key");
    }
}
