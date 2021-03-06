//
//  UISearchBar+Custom.swift
//  FindMe
//
//  Created by Ash Bhimasani on 7/22/17.
//  Copyright © 2017 Ash Bhimasani. All rights reserved.
//

import Foundation

import UIKit

extension UISearchBar {
    
    private func getViewElement<T>(type: T.Type) -> T? {
        
        let svs = subviews.flatMap { $0.subviews }
        guard let element = (svs.filter { $0 is T }).first as? T else { return nil }
        return element
    }
    
    func getSearchBarTextField() -> UITextField? {
        
        return getViewElement(type: UITextField.self)
    }
    
    func setTextColor(color: UIColor) {
        
        if let textField = getSearchBarTextField() {
            textField.textColor = color
        }
    }
    
    func setTextFieldColor(color: UIColor) {
        
        if let textField = getViewElement(type: UITextField.self) {
            switch searchBarStyle {
            case .minimal:
                textField.layer.backgroundColor = color.cgColor
                textField.layer.cornerRadius = 6
                
            case .prominent, .default:
                textField.backgroundColor = color
            }
        }
    }
    
    func setPlaceholderTextColor(color: UIColor) {
        
        if let textField = getSearchBarTextField() {
            textField.attributedPlaceholder = NSAttributedString(string: self.placeholder != nil ? self.placeholder! : "", attributes: [NSForegroundColorAttributeName: color])
        }
    }
    
//    func setTextFieldClearButtonColor() {
//        
//        if let textField = getSearchBarTextField() {
//            
//            let button = textField.value(forKey: "clearButton") as! UIButton
//            if let image = button.imageView?.image {
//                button.imageView?.tintColor = UIColor(red:0.99, green:0.66, blue:0.69, alpha:1.0)
//                button.setImage(image, for: .normal)
//            }
//        }
//    }
//
//    func setSearchImageColor(color: UIColor) {
//        
//        if let imageView = getSearchBarTextField()?.leftView as? UIImageView {
//            imageView.image = imageView.image?.transform(withNewColor: color)
//        }
//    }
}
