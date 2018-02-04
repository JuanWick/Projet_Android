package fr.esgi.schoolboyrun.data;

import java.util.List;

import fr.esgi.schoolboyrun.models.Score;
import fr.esgi.schoolboyrun.models.User;

/**
 * Created by JUAN_work on 05/02/2018.
 */

public interface IScoreRepository {
        public void addScore(Score score);
        public List<Score> getAllScore();
}
