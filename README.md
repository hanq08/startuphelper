# startuphelper
This is a startup-ready web skleleton that can be used to create website and sell ideas quickly.

This project is built based on Marco Tedone's project devopsbuddy. I've used cloudformation to wrapped this project's infrastructure and make it much easier to use for startup developers.

## Installation
The easiest way to install LambCI is to spin up a CloudFormation stack using startuphelper.template – this is just a collection of related AWS resources, including the private spring boot server, public web server, bastion host and RDS, that you can update or remove together – it should take around 3-4 minutes to spin up.

### 1. Launch the StartupHelper CLoudFormation stack
You can either use this direct link or navigate in your AWS Console to Services > CloudFormation, choose "Create Stack" and upload startuphelper.template from the root of this repository. 

Then click Next where you can enter a stack name. Click Next, and then Next again on the Options step (leaving the default options selected), to get to the final Review step. Check the acknowledgment checkbox and click Create to start the resource creation process.

### 2. Configuration
All configurations for startuphelper are stored in S3 bucket startuphelper-theodore-config and user may change the files in s3 and download it to the private spring boot server or user can ssh into the private spring boot server through the bastion host and modify the config files in ~/.devopsbuddy   
#### 1. Create a Amazon Stripe Token
Stripe is a suite of APIs that powers commerce for businesses of all sizes. This project uses stripe to charge monthly fee. Create stripe account by clicking this [link](https://stripe.com/). Then log into your account and create a subscription plan and name it. Open stripe.properties file and then ssh into your private spring boot server and replace key values in ~/.devopsbuddy/stripe.properties with your stripe private key and publishable key. Notice that stripe provides test account and production account. Use test account credentials if you want to test it.  
#### 2. Setup your email
You need to setup your email to receive feedback from customers. Replace dummy email in ~/.devopsbuddy/application-prod.properties with your email account details.
## Architecture Overview
![Architecture diagram](https://tqhan.xyz/images/detail/startup_helper_aws_architecture.PNG)
