package frc.robot;

import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator.Validity;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Pnuematics {

    private DoubleSolenoid _sol_deploy;
    private DoubleSolenoid _sol_deploy2;
    private DoubleSolenoid _sol_deploy3;
    private boolean ballpusherout;
    private boolean intaker;
    private boolean feeder;
    private static int kSolChannel_deploy = 2;
    private static int kSolChannel_deploy2 = 3;
    private static int kSolChannel_deploy3= 4;
    private static int kSolChannel_deploy4 =5;
    private static int kSolChannel_deploy5 =6;
    private static int kSolChannel_deploy6 =7;
    
    public Pnuematics() {
        _sol_deploy = new DoubleSolenoid(kSolChannel_deploy, kSolChannel_deploy2);
        _sol_deploy2 = new DoubleSolenoid(kSolChannel_deploy3, kSolChannel_deploy4);
        _sol_deploy3 = new DoubleSolenoid(kSolChannel_deploy5, kSolChannel_deploy6);
        intaker = false;
    }



    public void pushballout() {
        _sol_deploy.set(Value.kForward);
        ballpusherout = true;
    }

    public void bringballin() {
        _sol_deploy.set(Value.kReverse);
        ballpusherout = false;
    }

    public void bringballin2(){
        _sol_deploy3.set(Value.kReverse);
        feeder=true;
    }

    public void closemouth(){
        _sol_deploy3.set(Value.kReverse);
        feeder = false;
        
    }

 

    public void senddeployout(){
        _sol_deploy2.set(Value.kForward);
        intaker = true;
    }

    public void debug(){
        SmartDashboard.putBoolean("ball pusher out?", ballpusherout);
        SmartDashboard.putBoolean("intake out?", intaker);
        SmartDashboard.putBoolean("feeder out?", feeder);
    }

}