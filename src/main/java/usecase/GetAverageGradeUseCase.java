package usecase;

import api.GradeDataBase;
import entity.Grade;
import entity.Team;

/**
 * GetAverageGradeUseCase class.
 */
public final class GetAverageGradeUseCase {
    private final GradeDataBase gradeDataBase;

    public GetAverageGradeUseCase(GradeDataBase gradeDataBase) {
        this.gradeDataBase = gradeDataBase;
    }

    /**
     * Get the average grade for a course across your team.
     * @param course The course.
     * @return The average grade.
     */
    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.
        // Run the API to get all your teammembers' username
        float sum = 0;
        int count = 0;
        final Team team = gradeDataBase.getMyTeam();
        // Run the API to get all the grades for the course for all your teammembers
        for (String username : team.getMembers()) {
            // Run the API to get the grade for the course for the utorid
            final Grade[] grades = gradeDataBase.getGrades(username);
            for (Grade grade : grades) {

                if (grade.getCourse().equals(course)) {
                    // Sum all the grades
                    sum += grade.getGrade();
                    count++;
                }
            }
        }
        return sum / count;
    }
}
