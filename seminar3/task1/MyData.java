package seminar3.task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class MyData extends InputStream implements Serializable {
    @Override
    public int read() throws IOException {
        return 0;
    }
}
