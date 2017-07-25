//
//  LoginViewController.swift
//  Where's My Stuff
//
//  Created by Ash Bhimasani on 7/18/17.
//  Copyright © 2017 Ash Bhimasani. All rights reserved.
//

import UIKit
import Firebase
import FirebaseAuth
import FirebaseDatabase

class LoginViewController: UIViewController {
    
    var loginCount = 0
    
    @IBAction func back(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)
    }
    
    @IBOutlet weak var usernameTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
    @IBOutlet weak var loginButton: UIButton!
    @IBOutlet weak var forgotPassButton: UIButton!
    
    @IBOutlet weak var centerUsername: NSLayoutConstraint!
    @IBOutlet weak var centerPassword: NSLayoutConstraint!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        usernameTextField.layer.cornerRadius = 5
        passwordTextField.layer.cornerRadius = 5
        loginButton.layer.cornerRadius = 5
    }
    
    override var preferredStatusBarStyle : UIStatusBarStyle {
        return UIStatusBarStyle.lightContent
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
        centerUsername.constant -= view.bounds.width
        centerPassword.constant -= view.bounds.width
        loginButton.alpha = 0
        forgotPassButton.alpha = 0
        
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
            
            self.loginButton.alpha = 1
            
        }, completion: nil)
        
        UIView.animate(withDuration: 0.5, delay: 0.20, options: .curveEaseOut, animations: {
            
            self.forgotPassButton.alpha = 1
            
        }, completion: nil)
        
    }
    
    func badLoginAlert() {
        let alertController = UIAlertController(title: "Bad Login", message: "Incorrect Username or Password", preferredStyle: UIAlertControllerStyle.alert)
        alertController.addAction(UIAlertAction(title: "Ok", style: UIAlertActionStyle.default, handler: nil))
        present(alertController, animated: true, completion: nil)
        loginCount+=1
    }
    
    func lockedOutAlert() {
        let alertController = UIAlertController(title: "Locked Out", message: "Reached maximum login attempts (3)", preferredStyle: UIAlertControllerStyle.alert)
        alertController.addAction(UIAlertAction(title: "Ok", style: UIAlertActionStyle.default, handler: nil))
        present(alertController, animated: true, completion: nil)
        loginCount+=1
    }
    
    func invalidEmailAlert() {
        let alertController = UIAlertController(title: "Invalid Email", message: "Email not found", preferredStyle: UIAlertControllerStyle.alert)
        alertController.addAction(UIAlertAction(title: "Ok", style: UIAlertActionStyle.default, handler: nil))
        present(alertController, animated: true, completion: nil)
        loginCount+=1
    }
    
    func emailSentAlert() {
        let alertController = UIAlertController(title: "Email Sent!", message: "Check your inbox for a password reset link", preferredStyle: UIAlertControllerStyle.alert)
        alertController.addAction(UIAlertAction(title: "Ok", style: UIAlertActionStyle.default, handler: nil))
        present(alertController, animated: true, completion: nil)
        loginCount+=1
    }
    
    @IBAction func loginButtonDidTouch(_ sender: UIButton) {
        //Login Check
//        if (model.login(user: User(username: usernameTextField.text!, password: passwordTextField.text!))) {
//            print("Successfully logged in!")
//            print(model.getCurrentUser().getStatus())
//            performSegue(withIdentifier: "login2Map", sender: self)
//        } else {
//            badLoginAlert()
//        }
//
//        Auth.auth().signIn(withEmail: usernameTextField.text!, password: passwordTextField.text!)
//        model.register(user: User(username: self.usernameTextField.text!,password: self.passwordTextField.text!))
//        performSegue(withIdentifier: "login2Map", sender: self)
        
        Auth.auth().signIn(withEmail: usernameTextField.text!, password: passwordTextField.text!) { user, error in
            if error == nil && self.loginCount < 3 {
                model.setCurrentUser(user: User(username: self.usernameTextField.text!,password: self.passwordTextField.text!))
                self.performSegue(withIdentifier: "login2Map", sender: self)
            } else {
                if (self.loginCount >= 3) {
                    self.lockedOutAlert()
                }
                self.badLoginAlert()
            }
        }
        
        //        let bounds = self.loginButton.bounds
        loginButton.transform = CGAffineTransform(scaleX: 1.2, y: 1.2)
        
        //Animate
        UIView.animate(
            withDuration: 1.5,
            delay: 0.0,
            usingSpringWithDamping: 0.2,
            initialSpringVelocity: 4,
            options: UIViewAnimationOptions.curveLinear,
            animations: {
                
                [weak self] in self?.loginButton.transform = .identity
                
                //            self.loginButton.bounds = CGRect(x: bounds.origin.x - 20, y: bounds.origin.y, width: bounds.size.width + 60, height: bounds.size.height)
                //            self.loginButton.isEnabled = false
                
            }, completion: { finished in self.loginButton.isEnabled = true })
        
    }
    
    @IBAction func forgotPassDidTouch(_ sender: UIButton) {
        Auth.auth().sendPasswordReset(withEmail: usernameTextField.text!) { error in
            if error != nil {
                //Error - Invalid Email
                self.invalidEmailAlert()
            } else {
                // Success - Sent recovery email
                self.emailSentAlert()
            }
        }
    }
}

