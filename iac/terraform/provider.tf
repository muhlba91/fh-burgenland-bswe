terraform {
  required_providers {
    google = {
      source  = "hashicorp/google"
      version = "4.85.0"
    }
  }
}

provider "google" {
  project = "storied-shelter-431614"
}
