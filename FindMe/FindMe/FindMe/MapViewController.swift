//
//  MapViewController.swift
//  Where's My Stuff
//
//  Created by Ash Bhimasani on 7/19/17.
//  Copyright © 2017 Ash Bhimasani. All rights reserved.
//

import Foundation

import UIKit

import MapKit

import CoreLocation

import Firebase

import FirebaseDatabase


class MapViewController: UIViewController, MKMapViewDelegate, CLLocationManagerDelegate {
    
    @IBOutlet weak var mapView: MKMapView!
    
    let locationManager: CLLocationManager = CLLocationManager()
    
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    
    @IBAction func addLostItem(_ sender: UIButton) {
        print("+Lost clicked")
        let addAlert = UIAlertController(title: "Post New Lost Item", message: "", preferredStyle: .alert)
        
        let saveAction = UIAlertAction(title: "Save", style: .default, handler: {
            alert -> Void in
            
            let name = addAlert.textFields![0] as UITextField
            let description = addAlert.textFields![1] as UITextField
            let date = addAlert.textFields![2] as UITextField
            let reward = addAlert.textFields![3] as UITextField
            
//            let ref = Database.database().reference(withPath: "lost-items")
//            let itemRef = ref.childByAutoId()
//            let item = LostItem(user: model.getCurrentUser(), itemName: name.text!, latitude: self.latitude, longitude: self.longitude, descrip: description.text!, lostDate: date.text!)
//            itemRef.setValue(item.toAnyObject())
            
            model.addLost(lostIt: LostItem(user: model.getCurrentUser(), itemName: name.text!, latitude: self.latitude, longitude: self.longitude, descrip: description.text!, lostDate: date.text!, reward: reward.text!))

            print("lost post added")
            self.loadMap()
        })
        
        let cancelAction = UIAlertAction(title: "Cancel", style: .default, handler: {
            (action : UIAlertAction!) -> Void in
            print("cancel pressed")
            
        })
        
        addAlert.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "Name"
        }
        addAlert.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "Description"
        }
        addAlert.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "Date (M/DD)"
        }
        addAlert.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "Reward ($)"
        }
        
        addAlert.addAction(saveAction)
        addAlert.addAction(cancelAction)
        
        self.present(addAlert, animated: true, completion: nil)

    }
    
    @IBAction func addFoundItem(_ sender: UIButton) {
        print("+Found clicked")
        let addAlert = UIAlertController(title: "Post New Found Item", message: "", preferredStyle: .alert)
        
        let saveAction = UIAlertAction(title: "Save", style: .default, handler: {
            alert -> Void in
            
            let name = addAlert.textFields![0] as UITextField
            let description = addAlert.textFields![1] as UITextField
            let date = addAlert.textFields![2] as UITextField
            
//            let ref = Database.database().reference(withPath: "found-items")
//            let itemRef = ref.childByAutoId()
//            let item = FoundItem(user: model.getCurrentUser(), itemName: name.text!, latitude: self.latitude, longitude: self.longitude, descrip: description.text!, foundDate: date.text!)
//            itemRef.setValue(item.toAnyObject())
            
            model.addFound(foundIt: FoundItem(user: model.getCurrentUser(), itemName: name.text!, latitude: self.latitude, longitude: self.longitude, descrip: description.text!, foundDate: date.text!))
            
            print("found post added")
            self.loadMap()
            
        })
        
        let cancelAction = UIAlertAction(title: "Cancel", style: .default, handler: {
            (action : UIAlertAction!) -> Void in
            print("cancel pressed")
        })
        
        addAlert.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "Name"
        }
        addAlert.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "Description"
        }
        addAlert.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "Date (M/DD)"
        }
        
        addAlert.addAction(saveAction)
        addAlert.addAction(cancelAction)
        
        self.present(addAlert, animated: true, completion: nil)
    }
    
    @IBAction func logoutButton(_ sender: Any) {
        model.setCurrentUser(user: User(username: "",password: ""))
        performSegue(withIdentifier: "logoutSegue", sender: Any?.self)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        loadMap()
        
        // Ask for Authorization from the User.
        self.locationManager.requestAlwaysAuthorization()
        // For use in foreground
        self.locationManager.requestWhenInUseAuthorization()
        
        if CLLocationManager.locationServicesEnabled() {
            locationManager.delegate = self
            locationManager.desiredAccuracy = kCLLocationAccuracyNearestTenMeters
            locationManager.startUpdatingLocation()
            print("Updating location")
        }
        

    }

    func loadMap() -> Void {
        print("Begin Map Load")
        
        for item in model.getLost() {
            let annotation = MKPointAnnotation()
            let centerCoordinate = CLLocationCoordinate2D(latitude: item.getLatitude(), longitude: item.getLongitude())
            annotation.coordinate = centerCoordinate
            annotation.title = "\(item.getName())" + ": Lost"
            mapView.addAnnotation(annotation)
            let mapCenter = CLLocationCoordinate2DMake(item.getLatitude(), item.getLongitude())
            let span = MKCoordinateSpanMake(0.1, 0.1)
            let region = MKCoordinateRegionMake(mapCenter, span)
            mapView.region = region
        }
        for item in model.getFound() {
            let annotation = MKPointAnnotation()
            let centerCoordinate = CLLocationCoordinate2D(latitude: item.getLatitude(), longitude: item.getLongitude())
            annotation.coordinate = centerCoordinate
            annotation.title = "\(item.getName())" + ": Found"
            mapView.addAnnotation(annotation)
            let mapCenter = CLLocationCoordinate2DMake(item.getLatitude(), item.getLongitude())
            let span = MKCoordinateSpanMake(0.1, 0.1)
            let region = MKCoordinateRegionMake(mapCenter, span)
            mapView.region = region
        }
    }
    
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
//        let locValue: CLLocationCoordinate2D = manager.location!.coordinate
//        print("locations = \(locValue.latitude) \(locValue.longitude)")
//        latitude = locValue.latitude
//        longitude = locValue.longitude
        
        let lastLocation: CLLocation = locations[locations.count - 1]
        latitude = lastLocation.coordinate.latitude
        longitude = lastLocation.coordinate.longitude
        
//        print(latitude)
//        print(longitude)
    }
    
    
}
