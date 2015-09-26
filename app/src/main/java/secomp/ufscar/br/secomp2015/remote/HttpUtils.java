package secomp.ufscar.br.secomp2015.remote;

import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import secomp.ufscar.br.secomp2015.model.Access;

public class HttpUtils {

    private static final String HTTP_METHOD_GET = "GET";
    private static final String HTTP_METHOD_POST = "POST";

    private static final int MAX_BUFFER_SIZE = 1024;
    private static final int OFFSET = 0;

    public static <T> List<T> findBy(Map<String, Object> criteria) {
        return null;
    }

    public static <T> int save(final String destination, final T object) throws IOException, JSONException {
        URL url = new URL(destination) ;
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(HTTP_METHOD_POST);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        conn.connect();

        OutputStream outputStream = conn.getOutputStream();

        Class type = object.getClass();
        String parameters = null;

        if (object instanceof Access) {
            parameters = ((Access) object).toSendRemotely();
        }

        outputStream.write(parameters.getBytes("UTF8"));
        outputStream.flush();
        outputStream.close();

        return conn.getResponseCode();
    }

    private static String decode (final InputStream stream) throws IOException {
        byte[] buffer = new byte[MAX_BUFFER_SIZE];
        int currentBufferSize;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        while ((currentBufferSize = stream.read(buffer)) > 0) {
            baos.write(buffer, OFFSET, currentBufferSize);
        }

        return baos.toString();
    }
}
