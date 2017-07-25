//
//  RegisterViewController.swift
//  Where's My Stuff
//
//  Created by Ash Bhimasani on 7/18/17.
//  Copyright © 2017 Ash Bhimasani. All rights reserved.
//

import UIKit
import Firebase
import FirebaseAuth
import FirebaseDatabase

class RegisterViewController: UIViewController, SwiftySwitchDelegate {
    
    @IBAction func back(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)
    }
    
    @IBOutlet weak var usernameTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
    @IBOutlet weak var signupButton: UIButton!
    
    @IBOutlet weak var centerUsername: NSLayoutConstraint!
    @IBOutlet weak var centerPassword: NSLayoutConstraint!
    
    @IBOutlet weak var adminSwitch: SwiftySwitch!
    
    var isAdmin: Bool = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        usernameTextField.layer.cornerRadius = 5
        passwordTextField.layer.cornerRadius = 5
        signupButton.layer.cornerRadius = 5
        adminSwitch.delegate = self
    }
    
    func valueChanged(sender: SwiftySwitch) {
        if sender.isOn {
            //code when switch is turned on
            isAdmin = true
        } else {
            //code when switch is turned off
            isAdmin = false
        }
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override var preferredStatusBarStyle : UIStatusBarStyle {
        return UIStatusBarStyle.lightContent
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
        centerUsername.constant -= view.bounds.width
        centerPassword.constant -= view.bounds.width
        signupButton.alpha = 0
        
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        
        UIView.animate(withDuration: 0.5, delay: 0.00, options: UIViewAnimationOptions.curveEaseOut, animations: {
            
            self.centerUsername.constant += self.view.bounds.width
            self.view.layoutIfNeeded()
            
        }, completion: nil)
        
        UIView.animate(withDuration: 0.5, delay: 0.10, options: .curveEaseOut, animations: {
            
            self.centerPassword.constant += self.view.bounds.width
            self.view.layoutIfNeeded()
            
        }, completion: nil)
        
        UIView.animate(withDuration: 0.5, delay: 0.20, options: .curveEaseOut, animations: {
            
            self.signupButton.alpha = 1
            
        }, completion: nil)
        
    }
    
    func badRegisterAlert() {
        let alertController = UIAlertController(title: "Bad Register", message: "Email already taken | Password must be atleast 6 characters", preferredStyle: UIAlertControllerStyle.alert)
        alertController.addAction(UIAlertAction(title: "Ok", style: UIAlertActionStyle.default, handler: nil))
        present(alertController, animated: true, completion: nil)
    }
    
    @IBAction func signupButtonDidTouch(_ sender: UIButton) {
        //Register Check
//        if (model.register(user: User(username: usernameTextField.text!, password: passwordTextField.text!))) {
//            print("Successfully signed up!")
//            model.getCurrentUser().setStatus(status: isAdmin)
//            print(isAdmin)
//            performSegue(withIdentifier: "signUp2Map", sender: self)
//        } else {
//          badRegisterAlert()
//        }
        
//        if usernameTextField.text == "" {
//            let alertController = UIAlertController(title: "Error", message: "Please enter your email and password", preferredStyle: .alert)
//            
//            let defaultAction = UIAlertAction(title: "OK", style: .cancel, handler: nil)
//            alertController.addAction(defaultAction)
//            
//            present(alertController, animated: true, completion: nil)
//            
//        } else {
//            
//        Auth.auth().createUser(withEmail: usernameTextField.text!, password: passwordTextField.text!) { user, error in
//            if error == nil {
//                // 3
//                model.setCurrentUser(user: User(username: self.usernameTextField.text!, password: self.passwordTextField.text!))
//                self.performSegue(withIdentifier: "signUp2Map", sender: self)
//            } else {
//                self.badRegisterAlert()
//                }
//            }
//            
//        }
        
        Auth.auth().createUser(withEmail: usernameTextField.text!, password: passwordTextField.text!) { (user, error) in
            if error == nil {
                print("wiggle")
                model.setCurrentUser(user: User(username: self.usernameTextField.text!, password: self.passwordTextField.text!))
                self.performSegue(withIdentifier: "signUp2Map", sender: self)
            } else {
                self.badRegisterAlert()
            }
        }

        
        //        let bounds = self.signupButton.bounds
        signupButton.transform = CGAffineTransform(scaleX: 1.2, y: 1.2)
        
        //Animate
        UIView.animate(
            withDuration: 1.5,
            delay: 0.0,
            usingSpringWithDamping: 0.2,
            initialSpringVelocity: 4,
            options: UIViewAnimationOptions.curveLinear,
            animations: {
                
                [weak self] in self?.signupButton.transform = .identity
                
                //            self.signupButton.bounds = CGRect(x: bounds.origin.x - 20, y: bounds.origin.y, width: bounds.size.width + 60, height: bounds.size.height)
                //            self.signupButton.isEnabled = false
                
            }, completion: { finished in self.signupButton.isEnabled = true })
        
    }
    
    
}

