//
//  ViewController.swift
//  Where's My Stuff
//
//  Created by Ash Bhimasani on 7/17/17.
//  Copyright © 2017 Ash Bhimasani. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var signupButton: UIButton!
    @IBOutlet weak var loginButton: UIButton!
//    var loadDummy: Int = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        signupButton.layer.cornerRadius = 5
        loginButton.layer.cornerRadius = 5
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override var preferredStatusBarStyle : UIStatusBarStyle {
        return UIStatusBarStyle.lightContent
    }
    
    override func viewDidAppear(_ animated: Bool) {
//        if (loadDummy < 1) {
//        
//        //Adding in dummy data
//        let lost1 = LostItem(user: model.getCurrentUser(), itemName: "Pack of Cigs", latitude: 33.770957, longitude: -84.389377, descrip: "Marlboro Blues", lostDate: "7/20")
//        let lost2 = LostItem(user: model.getCurrentUser(), itemName: "Ash's iPhone 6s", latitude: 33.775973, longitude: -84.385292, descrip: "White iPhone, Blue Case", lostDate: "7/18")
//        let found1 = FoundItem(user: model.getCurrentUser(), itemName: "Ash Bhimasani's iPhone", latitude: 33.867351, longitude: -84.607154, descrip: "White iPhone left in Lyft car", foundDate: "7/19")
//        let found2 = FoundItem(user: model.getCurrentUser(), itemName: "Green Scissors", latitude: 33.776520, longitude: -84.392353, descrip: "Green scissors left in bathroom", foundDate: "6/21")
//        
//        model.addLost(lostIt: lost1)
//        model.addLost(lostIt: lost2)
//        model.addFound(foundIt: found1)
//        model.addFound(foundIt: found2)
//        
//        loadDummy += 1
//        }
        
        model.updateLost()
        model.updateFound()
    }


}

