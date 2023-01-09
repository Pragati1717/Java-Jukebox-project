package MyExceptions;

import java.sql.SQLException;

public class SongNotFound extends SQLException {
        public SongNotFound(String message) {
            super(message);
        }

}
