/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unesp.frontend.thales.hotel.request;

import br.com.unesp.frontend.thales.hotel.exceptions.NotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.Map;

/**
 *
 * @author Eduks
 */
public class HttpClient {

    private static final Gson gson = new Gson();

    public static <T> T get(String urlString, Class<T> responseClass) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int status = conn.getResponseCode();
        if (status != 200) {
            throw new NotFoundException("Erro HTTP: " + status);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }

            System.out.println("JSON recebido: " + content);

            return gson.fromJson(content.toString(), responseClass);
        } finally {
            conn.disconnect();
        }
    }

    public static <T> T getList(String urlString, Type typeOfT) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int status = conn.getResponseCode();
        if (status != 200) {
            throw new RuntimeException("Erro HTTP: " + status);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), java.nio.charset.StandardCharsets.UTF_8))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }

            System.out.println("JSON recebido: " + content);
            return gson.fromJson(content.toString(), typeOfT);
        } finally {
            conn.disconnect();
        }
    }

    public static <T> T get(String urlString, Class<T> responseClass, Map<String, String> headers) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Adiciona os headers
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        int status = conn.getResponseCode();
        if (status != 200) {
            throw new RuntimeException("Erro HTTP: " + status);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }

            return gson.fromJson(content.toString(), responseClass);
        } finally {
            conn.disconnect();
        }
    }

    public static <T> T post(String urlString, Object requestBody, Class<T> responseClass, Map<String, String> headers) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        String jsonInput = gson.toJson(requestBody);
        try (var os = conn.getOutputStream()) {
            byte[] input = jsonInput.getBytes(java.nio.charset.StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int status = conn.getResponseCode();
        if (status < 200 || status >= 300) {
            throw new RuntimeException("Erro HTTP: " + status);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), java.nio.charset.StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            System.out.println("JSON de resposta: " + response);
            return gson.fromJson(response.toString(), responseClass);
        } finally {
            conn.disconnect();
        }
    }

    public static <T> T post(String urlString, Object requestBody, Type responseType, Map<String, String> headers) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        String jsonInput = gson.toJson(requestBody);
        try (var os = conn.getOutputStream()) {
            byte[] input = jsonInput.getBytes(java.nio.charset.StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int status = conn.getResponseCode();
        if (status < 200 || status >= 300) {
            throw new RuntimeException("Erro HTTP: " + status);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), java.nio.charset.StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            System.out.println("JSON de resposta: " + response);
            return gson.fromJson(response.toString(), responseType);
        } finally {
            conn.disconnect();
        }
    }

    public static <T> T delete(String urlString, Object requestBody, Type responseType, Map<String, String> headers) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");
        conn.setDoOutput(true); // Permitir corpo
        conn.setRequestProperty("Content-Type", "application/json");

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        // Escreve o corpo (por exemplo, {"id": 123})
        if (requestBody != null) {
            String jsonInput = gson.toJson(requestBody);
            try (var os = conn.getOutputStream()) {
                byte[] input = jsonInput.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
        }

        int status = conn.getResponseCode();
        if (status < 200 || status >= 300) {
            throw new RuntimeException("Erro HTTP: " + status);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), java.nio.charset.StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            System.out.println("JSON de resposta: " + response);
            return gson.fromJson(response.toString(), responseType);
        } finally {
            conn.disconnect();
        }
    }

}
