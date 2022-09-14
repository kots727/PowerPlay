package com.example.meepmeepsequences;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.*;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        // Declare a MeepMeep instance
        // With a field size of 800 pixels
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Required: Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                // Option: Set theme. Default = ColorSchemeRedDark()
                .setColorScheme(new ColorSchemeRedDark())
                .followTrajectorySequence(drive ->
                 drive.trajectorySequenceBuilder(new Pose2d(70-12, 35)
								.lineWithConstantHeading(70-12,12.5)
								.lineWithLinearHeading(12,12.5,Math.toRadians(0))
								.lineWithConstantHeading(12,70)
                                                //cycles
								.lineWithConstantHeading(12,23.3)
								.lineWithConstantHeading(6.6,23.3)
								.lineWithConstantHeading(12,23.3)
								.lineWithConstantHeading(12,70)
								.lineWithConstantHeading(12,23.3)
								.lineWithConstantHeading(6.6,23.3)
								.lineWithConstantHeading(12,23.3)
								.lineWithConstantHeading(12,70)
								.lineWithConstantHeading(12,23.3)
								.lineWithConstantHeading(6.6,23.3)
								.lineWithConstantHeading(12,23.3)
								.lineWithConstantHeading(12,70)
                                                 //return to signal location
								.lineWithConstantHeading(12,12)
                                .build()
                );

        // Set field image
        meepMeep.setBackground(MeepMeep.Background.FIELD_FREIGHTFRENZY_ADI_DARK)
                .setDarkMode(true)
                // Background opacity from 0-1
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
