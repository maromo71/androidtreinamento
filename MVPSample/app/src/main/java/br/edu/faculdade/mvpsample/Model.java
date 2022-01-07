package br.edu.faculdade.mvpsample;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Model implements Contract.Model{
    private List<String> arrayList = Arrays.asList(
            "Curso Git e Github: Git é o sistema de controle de versão de arquivos " +
                    "mais utilizado no mundo.",
            "Desenvolvimento de Aplicativos Android usando Kotlin: Adquira sólidos " +
                    "conhecimentos em Kotlin e utilize na criação de Apps Android! " +
                    "Curso mais completo sobre Kotlin em PT-BR!.",
            "Curso de JavaScript e TypeScript do básico ao avançado 2021: Javascript " +
                    "e TypeScript - front-end e back-end (Full Stack) - Node, Express, " +
                    "noSQL, React, hooks, Redux, Design Patterns",
            "React Native: Desenvolva APPs Nativas para Android e iOS",
            "Curso Completo do Desenvolvedor NodeJS e MongoDB: Aprenda a criar sites" +
                    " e sistemas web utilizando a plataforma NodeJS e o banco " +
                    "de dados MongoDB"
    );

    private String getRandomString() {
        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        return arrayList.get(index);
    }

    @Override
    public void getNextCourse(OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(getRandomString());
            }
        }, 1200);
    }


}
