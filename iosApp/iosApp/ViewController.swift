//
//  ViewController.swift
//  iosApp
//
//  Created by ninehundreds on 2/1/22.
//

import UIKit
import Shared

class ViewController: UIViewController {

    @IBOutlet weak var titleLabel: UILabel!

    override func viewDidLoad() {
        super.viewDidLoad()

        titleLabel.text = Greeting().greet()
        
        getAllWhizBangs()
    }
    
    private func getAllWhizBangs(){
        Task{
            try await appClient.getWhizBangs(
                success: {
                    whizBangs in print("")
                },
                failure: {
                    print(error?.description ?? "unkown error")
                }
            )
        }
    }


}

