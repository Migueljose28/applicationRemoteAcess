package com.remote.acess.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class ScriptService {

    public String executarScript(String comando, List<String> args) throws IOException, InterruptedException {
        var cmd = new java.util.ArrayList<String>();
        cmd.add(comando);
        cmd.addAll(args);

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectErrorStream(true);
        Process p = pb.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            StringBuilder sb = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                sb.append(linha).append("\n");
            }
            int exitCode = p.waitFor();
            return "ExitCode: " + exitCode + "\nSaída:\n" + sb;
        }
    }
}

