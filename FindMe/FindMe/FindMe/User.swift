//
//  User.swift
//  Where's My Stuff
//
//  Created by Ash Bhimasani on 7/18/17.
//  Copyright © 2017 Ash Bhimasani. All rights reserved.
//

import Foundation

//let user = User()
//
//var userArray = [User]()

class User {
    var username : String = ""
    var password : String = ""
    var isAdmin : Bool
    
    init(username: String, password: String) {
        self.username = username
        self.password = password
        self.isAdmin = false
    }
    
    func getUserName() -> String {
        return username
    }
    func getPassword() -> String {
        return password
    }
    func getStatus() -> Bool {
        return isAdmin
    }
    func setUserName(userName : String) -> Void{
        username = userName
    }
    func setPassword(passWord : String) -> Void {
        password = passWord
    }
    func setStatus(status : Bool) -> Void {
        isAdmin = status
    }
}
