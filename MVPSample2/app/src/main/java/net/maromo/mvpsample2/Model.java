package net.maromo.mvpsample2;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Model implements Contract.Model{

    private List<String> list = Arrays.asList(
            "C1: descrição do curso 1",
            "C2: descrição do curso 2",
            "C3: descrição do curso 3",
            "C4: descrição do curso 4",
            "C5: descrição do curso 5",
            "C6: descrição do curso 6",
            "C7: descrição do curso 7",
            "C8: descrição do curso 8",
            "C9: descrição do curso 9",
            "C10: descrição do curso 10"

    );

    private String getRandomString(){
        Random r = new Random();
        int i = r.nextInt(list.size());
        return list.get(i);
    }

    @Override
    public void getNextCourse(OnFinishedListener onFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onFinishedListener.onFininhed(getRandomString());
            }
        }, 1200);
    }

}
