import controllers.Keys;
import org.apache.commons.lang3.StringUtils;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        // TODO use DI
        Keys.PUBLIC_KEY = app.configuration().getString("marvel.public.key");
        Keys.PRIVATE_KEY = app.configuration().getString("marvel.private.key");

        if (StringUtils.isBlank(Keys.PRIVATE_KEY)) {
            throw new RuntimeException("Private Key is blank");
        }

        if (StringUtils.isBlank(Keys.PUBLIC_KEY)) {
            throw new RuntimeException("Private Key is blank");
        }
    }
}
